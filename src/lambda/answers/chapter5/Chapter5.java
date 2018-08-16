package lambda.answers.chapter5;

import lambda.demo.Album;
import lambda.demo.Artist;
import lambda.demo.Track;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter5 {

    private static Comparator<String> byNameLength = Comparator.comparing(String::length);

    //1.方法引用 略

    //2.收集器

    //2.a 找出名字最长的艺术家
    public static Optional<String> findTheLongestArtistNameByCollectors(Stream<String> names){
        return names.max(Comparator.comparing(String::length));
    }

    public static Optional<String> findTheLongestArtistNameByReduce(Stream<String> names){
        return names.reduce((s1, s2) -> byNameLength.compare(s1,s2) >= 0 ? s1 : s2);
    }

    //2.b 假设一个元素为单词的流,计算每个单词出现的次数。
    public static Map<String,Long> countWordFrequency(Stream<String> words){
        return words.collect(Collectors.groupingBy(name -> name,Collectors.counting()));
    }

    //2.c 用一个定制的收集器实现Collectors.groupingBy方法。 每个主艺术季对应的专辑数
    public static Map<Artist,List<Album>> customGroupingBy(List<Album> albums){
        return albums.stream().collect(new GroupingBy<>(Album::getMainMusician));
    }


}
