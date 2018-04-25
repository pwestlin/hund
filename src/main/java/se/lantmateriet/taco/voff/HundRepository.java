package se.lantmateriet.taco.voff;

import org.springframework.stereotype.Repository;
import se.lantmateriet.taco.voff.Hund.Ras;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class HundRepository {

    private List<Hund> hundar = new ArrayList<>();

    public HundRepository() {
        initHundar();
    }

    public Optional<Hund> getHund(int id) {
        return this.hundar.stream()
            .filter(hund -> hund.id == id)
            .findFirst();
    }

    public List<Hund> getHundarByRas(Ras ras) {
        return getHundar(hund -> hund.ras.equals(ras));
    }

    public List<Hund> getHundarByNamn(String namn) {
        return getHundar(hund -> hund.namn.equals(namn));
    }

    public List<Hund> getHundar() {
        return hundar.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public List<Hund> getHundar(Predicate<Hund> predicate) {
        return hundar.stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }

    private void initHundar() {
        this.addHund(Ras.DOGO_CANARIO, "Bengt");
        this.addHund(Ras.DOGO_CANARIO, "Ambra");
        this.addHund(Ras.TIBETANSK_TERRIER, "Humlan");
        this.addHund(Ras.ROTWEILER, "Sensi");
        this.addHund(Ras.COLLIE, "Lassie");
        this.addHund(Ras.UNKNOWN, "Selma");
    }

    public Hund addHund(Ras ras, String namn) {
        Hund hund = new Hund(createId(), ras, namn);
        hundar.add(hund);

        return hund;
    }

    private int createId() {
        return this.hundar.stream()
            .mapToInt(hund -> hund.id)
            .max().orElse(0) + 1;
    }

}
