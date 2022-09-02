package listvsset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kamdon Bird
 *
 */
public class ListVsSetDemo implements Serializable {
    /**
     * 
     */
    private final List<ColoredSquare> list;
    /**
     * 
     */
    private final Set<ColoredSquare> set;

    /**
     * @param elements
     */
    public ListVsSetDemo(ColoredSquare... elements) {
        list = new ArrayList<>(Arrays.asList(elements));
        set = new HashSet<>(Arrays.asList(elements));
    }

    /**
     * @return a String of a ColoredSqaure
     */
    public String getListElements() {
        StringBuilder sb = new StringBuilder();
        for (ColoredSquare el : list) {
            sb.append(el).append("\n");
        }
        return sb.toString();
    }

    /**
     * @return a String of a ColoredSqaure
     */
    public String getSetElements() {
        StringBuilder sb = new StringBuilder();
        for (ColoredSquare el : set) {
            sb.append(el).append("\n");
        }
        return sb.toString();
    }

    public void addElement(ColoredSquare el) {
        list.add(el);
        set.add(el);
    }
}
