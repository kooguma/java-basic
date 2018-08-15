package lambda.answers.chapter3;

import lambda.demo.Album;
import lambda.demo.Artist;
import lambda.demo.Track;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter3 {

    //1.编写一个求和函数，计算流中所有数之和
    public static int addUp(IntStream numbers) {
        return numbers.reduce(0, (i1, i2) -> i1 + i2);
    }

    //2.编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍
    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .flatMap((Function<Artist, Stream<String>>) artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    //3.编写一个函数，接受专辑列表作为参数，返回一个由最多包含3首歌曲的专辑组成的列表
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }

    //4.迭代。修改如下代码，将外部迭代转换成内部迭代
    public static long countBandMembersExternal(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        return totalMembers;
    }

    public static long countBandMembersInternal(List<Artist> artists) {

//        return artists.stream()
//                .map(artist -> artist.getMembers().count())
//                .reduce(0L, Long::sum)
//                .intValue();
        return artists.stream()
                .flatMap(Artist::getMembers)
                .count();
    }





}
