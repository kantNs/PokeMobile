package com.github.vincebrees.pokemonlist.data.pojo;

import com.github.vincebrees.pokemonlist.domain.Pokemon;

import java.util.List;
import java.util.Objects;

/**
 * Created by Vincent ETIENNE on 26/11/2018.
 */

//Old Way to have a Pojo with Java
public class RestPokemonDataJava {
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<Pokemon> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestPokemonDataJava that = (RestPokemonDataJava) o;
        return Objects.equals(count, that.count) &&
                Objects.equals(next, that.next) &&
                Objects.equals(previous, that.previous) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {

        return Objects.hash(count, next, previous, results);
    }
}
