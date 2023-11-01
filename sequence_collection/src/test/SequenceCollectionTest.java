import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class SequenceCollectionTest {

    @Test
    void sequenceList() {

        SequencedCollection<String> list = new ArrayList<>();
        list.addLast("Andi");
        list.addFirst("Ahmad");
        list.addFirst("Abdul");
        System.out.println(list);

        Assertions.assertEquals(List.of("Abdul", "Ahmad", "Andi"), list);
        Assertions.assertEquals("Abdul",list.getFirst());

        SequencedCollection<String> reversed = list.reversed();
        System.out.println(reversed);

        String removeFirst = reversed.removeFirst();
        Assertions.assertEquals("Andi",removeFirst);
        System.out.println(reversed);
    }
}
