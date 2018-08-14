package lambda.example.chapter5;

import lambda.demo.Album;
import lambda.demo.Artist;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Chapter5 {

    //1.在一个有序集合中创建一个流时，流中的元素就按出现顺序排列
    @SuppressWarnings("SimplifyStreamApiCallChains")
    public static List<Integer> collectionOrdered(List<Integer> numbers) {
        return numbers.stream().collect(toList());
    }

    //2.如果集合本身就是无序的，由此生成的流也是无序的
    @SuppressWarnings("SimplifyStreamApiCallChains")
    public static List<Integer> collectionDisOrdered(Set<Integer> numbers) {
        return numbers.stream().collect(toList());
    }

    //3.找出成员组最多的乐队
    public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.max(Comparator.comparing(getCount));
    }

    //4.找出一组专辑上曲目的平均数
    public static double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }

    //5.Collectors partitioningBy 数据分块
    public static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    //6.Collectors groupingBy 数据分组
    public static Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

    //7.Collectors String  格式化艺术家姓名
    public static String artistNameFormat(Stream<Artist> artists) {
        return artists.map(Artist::getName).collect(Collectors.joining(",", "[", "]"));
    }

    //8.Collectors groupingBy counting 计算每个艺术家的专辑数
    public static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
    }

    //9.Collectors groupingBy mapping 求每个艺术家的专辑名
    public static Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.mapping(Album::getName, Collectors.toList())));
    }

    //10.定制收集器
    public static String customCollectors1(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        return builder.toString();
    }

    public static String customCollectors2(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                });
        builder.append("]");
        return builder.toString();
    }

    public static String customCollectors3(List<Artist> artists) {
        StringBuilder reduced =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringBuilder(), (builder, name) -> {
                            if (builder.length() > 0)
                                builder.append(", ");
                            return builder;
                        }, StringBuilder::append);
        reduced.insert(0, "[");
        reduced.append("]");
        return reduced.toString();
    }

    public static String customCollectors4(List<Artist> artists) {
        StringCombiner combiner =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringCombiner(", ", "[", "]"),
                                StringCombiner::add,
                                StringCombiner::merge);
        return combiner.toString();
    }

    public static String customCollectors(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(",", "[", "]"));
    }

}
