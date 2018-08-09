package lambda.answers.chapter4;

import lambda.demo.Artist;

import java.util.stream.Stream;

public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist),artist.getMembers()));
    }
}
