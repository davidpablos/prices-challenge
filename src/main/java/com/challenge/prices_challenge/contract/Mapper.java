package com.challenge.prices_challenge.contract;

public interface Mapper<T, V> {

	V map(T input);

}