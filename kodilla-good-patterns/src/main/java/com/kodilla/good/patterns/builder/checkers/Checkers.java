package com.kodilla.good.patterns.builder.checkers;

public class Checkers {

    private final Board board;
    private final String playerOne;
    private final String playerTwo;

    private Checkers(Board board, String playerOne, String playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Board getBoard() {
        return board;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public static class CheckersBuilder {

        private Board board = new Board();
        private String playerOne = "";
        private String playerTwo = "";

        public CheckersBuilder playerOne(String playerOne) {
            this.playerOne = playerOne;
            return this;
        }

        public CheckersBuilder playerTwo(String playerTwo) {
            this.playerTwo = playerTwo;
            return this;
        }

        public CheckersBuilder Figure(String figureType, String figureColor, int x, int y) {
            if (x > Board.MAX_INDEX || x < Board.MIN_INDEX || y > Board.MAX_INDEX || y < Board.MIN_INDEX) {
                throw new IllegalStateException("Figure position is out of the board!");
            }
            if (board.getFigure(x, y) == null) {
                board.setFigure(FigureFactory.makeFigure(figureType, figureColor), x, y);
            } else {
                throw new IllegalStateException("There is already a figure at position: " + x + "," + y);
            }
            return this;
        }

        public Checkers build() {
            if (playerOne.length() == 0) {
                throw new IllegalStateException("playerOne is empty!");
            }
            if (playerTwo.length() == 0) {
                throw new IllegalStateException("playerTwo is empty!");
            }
            boolean white = false, black = false;
            for (int x = Board.MIN_INDEX; x <= Board.MAX_INDEX; x++) {
                for (int y = Board.MIN_INDEX; y <= Board.MAX_INDEX; y++) {
                    Figure figure = board.getFigure(x, y);
                    if (figure != null) {
                        if (figure.getColor().equals(Figure.WHITE)) {
                            white = true;
                        } else if (figure.getColor().equals(Figure.BLACK)) {
                            black = true;
                        }
                    }
                }
            }
            if (!(white && black)) {
                throw new IllegalStateException("There should be at least one WHITE and one BLACK figure on the board!");
            }
            return new Checkers(board, playerOne, playerTwo);
        }
    }
}
