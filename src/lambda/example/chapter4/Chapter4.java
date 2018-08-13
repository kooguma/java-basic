package lambda.example.chapter4;

import lambda.demo.Album;
import lambda.demo.Track;

import java.util.IntSummaryStatistics;

public class Chapter4 {


    //1.使用 summaryStatistics方法统计曲目长度
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats
                = album.getTracks()
                .mapToInt(Track::getLength)
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }



}
