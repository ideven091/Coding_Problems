package com.cleo.forkJoin;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2,jvmArgs = {"-Xms4G", "-Xmx4G"})

public class ParallelStreamBenchMark {

    private static final long N= 10_000_000L;

    @Benchmark
    public static long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce( 0L, Long::sum);
    }
    @Benchmark
    public static long rangedSum() {
        return LongStream.rangeClosed(1, N)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        rangedSum();
    }

}
