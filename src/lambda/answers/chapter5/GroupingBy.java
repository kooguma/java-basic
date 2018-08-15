package lambda.answers.chapter5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private final static Set<Characteristics> characteristics = new HashSet<>();

    static {
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }

    private final Function<? super T, ? extends K> classifier;

    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() { // <Long,List<>>
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (kListMap, t) -> {
            K key = classifier.apply(t);
            List<T> elements = kListMap.computeIfAbsent(key, k -> new ArrayList<>());
            elements.add(t);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            right.forEach((k, ts) -> left.merge(k, ts, (l, r) -> {
                l.addAll(r);
                return l;
            }));
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
