import java.util.*;

public class RangeImpl implements Range {
    private List<Long> list;
    private long size;
    private long lowerBound;
    private long upperBound;

    public RangeImpl(long start, long end) {
        checkBounds(start, end);
        size = end - start + 1;
        lowerBound = start;
        upperBound = end;
    }

    private void checkBounds(long start, long end) {
        if (start > end) {
            throw new IllegalArgumentException("start is greater than end");
        }
    }

    public boolean isBefore(Range otherRange) {
        return this.getUpperBound() < otherRange.getLowerBound();
    }

    public boolean isAfter(Range otherRange) {
        return this.getLowerBound() > otherRange.getUpperBound();
    }

    public boolean isConcurrent(Range otherRange) {
        return !this.isAfter(otherRange) && !this.isBefore(otherRange);
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() {
        return upperBound;
    }

    public boolean contains(long value) {
        return value >= getLowerBound() && value <= getUpperBound();
    }

    public List<Long> asList() {
        if (list == null) {
            list = getListOfRangeElements();
        }
        return list;
    }

    private List<Long> getListOfRangeElements() {
        List<Long> list = new ArrayList<>((int) size);
        for (long i = 0; i < size; i++) {
            list.add(getLowerBound() + i);
        }
        return list;
    }

    public Iterator<Long> asIterator() {
        return asList().iterator();
    }
}
