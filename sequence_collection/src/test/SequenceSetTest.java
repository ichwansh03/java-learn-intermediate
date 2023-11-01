import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.TreeSet;

public class SequenceSetTest {

    @Test
    void setTest() {
        SequencedSet<String> names = new LinkedHashSet<>();
        names.addFirst("Ali");
        names.addLast("Bambang");
        names.addFirst("Budi");

        System.out.println(names);

        SequencedSet<String> reversed = names.reversed();
        System.out.println(reversed);

        System.out.println(reversed.removeFirst());
        System.out.println(reversed);
    }
}
