package lambda.answers.chapter5;

import lambda.demo.Album;
import lambda.demo.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter5 {

    // Collectors maxBy
    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.max(Comparator.comparing(getCount));
    }

    // Collectors averagingInt
    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }

    // Collectors partitioningBy 数据分块
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    // Collectors groupingBy 数据分组
    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

    // Collectors String  格式化艺术家姓名
    public String artistNameFormat(Stream<Artist> artists) {
        return artists.map(Artist::getName).collect(Collectors.joining(",", "[", "]"));
    }

    // Collectors groupingBy counting 计算每个艺术家的专辑数
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
    }

    // Collectors groupingBy mapping 求每个艺术家的专辑名
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.mapping(Album::getName, Collectors.toList())));
    }

    // Collector 定制收集器
}
