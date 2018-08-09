package lambda.answers.chapter4;

import lambda.demo.Artist;

import java.util.stream.Stream;

public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();
}
