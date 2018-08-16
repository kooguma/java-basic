package lambda.answers.chapter5;

import lambda.demo.Album;
import lambda.demo.Artist;
import lambda.demo.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static lambda.answers.chapter5.Chapter5.*;

public class Chapter5Test {

    private String[] fullNames = new String[]{
            "John Lennon", "Paul McCartney", "George Harrison",
            "Ringo Starr", "Pete Best", "Stuart Sutcliffe"
    };

    private String[] nickNames = new String[]{
            "John","Paul","George","John","Paul","John"
    };

    @Test
    public void findTheLongestArtistNameByCollectorsTest() {
        Optional<String> actual = findTheLongestArtistNameByCollectors(Stream.of(fullNames));
        Optional<String> expected = Optional.of("Stuart Sutcliffe");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findTheLongestArtistNameByReduceTest() {
        Optional<String> actual = findTheLongestArtistNameByReduce(Stream.of(fullNames));
        Optional<String> expected = Optional.of("Stuart Sutcliffe");
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void countWordFrequencyTest() {
        Map<String,Long> actual = countWordFrequency(Stream.of(nickNames));
        Map<String,Long> expected = new HashMap<>();
        expected.put("John",3L);
        expected.put("Paul",2L);
        expected.put("George",1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void customGroupingByTest() {
        Map<Artist,List<Album>> actual = customGroupingBy(SampleData.getThreeAlbums());
        Map<Artist,List<Album>> expected = new HashMap<>();
        expected.put(SampleData.johnColtrane,SampleData.getThreeAlbums());
        Assert.assertEquals(expected,actual);


    }
}
