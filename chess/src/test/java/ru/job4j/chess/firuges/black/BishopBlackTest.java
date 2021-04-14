package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.ImpossibleMoveException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenPositionC1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void whenCopyToDestE3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.copy(Cell.E3).position(), is(Cell.E3));
    }

    @Test
    public void whenWayFromC1toG5() {
        Cell[] expected = {
                Cell.D2,
                Cell.E3,
                Cell.F4,
                Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5), is(expected));
    }

    @Test
    public void whenWayFromG5toC1() {
        Cell[] expected = {
                Cell.F4,
                Cell.E3,
                Cell.D2,
                Cell.C1
                };
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        assertThat(bishopBlack.way(Cell.C1), is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonalThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        bishopBlack.way(Cell.G1);
    }
}