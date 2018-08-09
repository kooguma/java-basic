package lambda.example.chapter3;

import lambda.demo.Album;
import lambda.demo.Artist;
import lambda.demo.Track;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Chapter3 {

    //1.使用内部迭代计算来自伦敦的艺术家人数
    public static long getArtistsCountFromLondon(List<Artist> artists){
        return artists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
    }

    //2.使用

    //2.找出某张专辑上所有乐队的国籍
    public static Set<String> getOrigins(Album album) {
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(Collectors.toSet());
    }

    //3.找出某张专辑上长度大于1分钟的曲目
    public static Set<String> finLongTracks(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .filter(t -> t.getLength() > 60)
                .map(Track::getName)
                .collect(Collectors.toSet());
    }
}
