import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.SequencedMap;
import java.util.TreeMap;

public class SequenceMapTest {

    @Test
    void mapTest() {
        SequencedMap<Integer, String> maps = new TreeMap<>();
        maps.put(1, "Abdul");
        maps.put(2, "Ahmad");
        maps.put(3, "Andi");

        Assertions.assertEquals("Abdul", maps.firstEntry().getValue());
        Assertions.assertEquals("Andi", maps.lastEntry().getValue());

        SequencedMap<Integer, String> reversed = maps.reversed();
        for (Map.Entry<Integer, String> value: reversed.entrySet()) {
            System.out.println(value.getKey() +" : "+value.getValue());
        }
    }
}
