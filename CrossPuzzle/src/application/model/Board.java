package application.model;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private char[][] board;
	private int[][] orientation;
	private int BOARD_SIZE = 10;
	private int wordCount = 0;
	
	public Board (int boardSize) {
		this.BOARD_SIZE = boardSize;
		board = blankBoardC();
		orientation = blankBoardI();
	}
	
	public int getBoardSize () {
		return this.BOARD_SIZE;
	}
	
	public void setBoardSize(int boardSize) {
		this.BOARD_SIZE = boardSize;
	}
	
	public char[][] getGameBoard() {
		return this.board;
	}
	
	public char[][] blankBoardC() {
		char[][] newBoard = new char[BOARD_SIZE][BOARD_SIZE];
		for(int x = 0; x < BOARD_SIZE; x++) {
			for(int y = 0; y < BOARD_SIZE; y++) {
				newBoard[x][y] = '0';
			}
		}
		return newBoard;
	}
	
	public int[][] blankBoardI() {
		int[][] newBoard = new int[BOARD_SIZE][BOARD_SIZE];
		for(int x = 0; x < BOARD_SIZE; x++) {
			for(int y = 0; y < BOARD_SIZE; y++) {
				newBoard[x][y] = 0;
			}
		}
		return newBoard;
	}
	
	public void addToBoard(String word) {
		Random r = new Random();
		boolean positionCheck = false; boolean overlapCheck = false;
		int x = r.nextInt(BOARD_SIZE);
		int y = r.nextInt(BOARD_SIZE); 
		int searchCase = 0; int oX = x; int oY = y; //keep track of original x and y to check for overlap
		int iOrientation = 0; // positive is up/down, negative is left/right
		
		while(!positionCheck) {
			while (overlapCheck) {
				positionCheck = true;
				if (board[x][y] == '0') {
					overlapCheck = false;
					
					for(int i = 0; i < word.length(); i++) {
						iOrientation = 1;
						if (y + i >= BOARD_SIZE || board[x][y+i] != '0') {
							overlapCheck = true;
							iOrientation = 0;
							break;
						}
					}
					for(int i = 0; i < word.length(); i++) {
						iOrientation = -1;
						if (x + i >= BOARD_SIZE || board[x+i][y] != '0') {
							overlapCheck = true;
							iOrientation = 0;
							break;
						}
					}
				}
				
				if (overlapCheck) {
					x++;
					if(x % BOARD_SIZE == 0) {
						x = 0;
						y++;
					}
					if(y % BOARD_SIZE == 0) 
						y = 0;
					if (x == oX && y == oY) {
						searchCase = -1;
						overlapCheck = false;
					}
				}
			}
			if (board[x][y] != '0') {
				int index = word.indexOf(board[x][y]);
				if (index != -1) {
					positionCheck = true;
					if (orientation[x][y] < 0) {
						iOrientation = 1;
						for(int i = 0; i < index; i++) {
							if (y - i < 0 || board[x][y-i] != '0') {
								positionCheck = false;
								iOrientation = 0;
								break;
							}
						}
						for(int i = index + 1; i < word.length(); i++) {
							if (y + i >= BOARD_SIZE || board[x][y+i] != '0') {
								positionCheck = false;
								iOrientation = 0;
								break;
							}
						}
						
					} else {
						iOrientation = -1;
						for(int i = 0; i < index; i++) {
							if (x - i < 0 || board[x-i][y] != '0') {
								positionCheck = false;
								iOrientation = 0;
								break;
							}
						}
						for(int i = index + 1; i < word.length(); i++) {
							if ( x + i >= BOARD_SIZE || board[x+i][y] != '0') {
								positionCheck = false;
								iOrientation = 0;
								break;
							}
						}
					}
					if(positionCheck)
						searchCase = 1;
				}
			} else if (wordCount == 0) {
				positionCheck = true;
				double randNum = r.nextDouble();
				if (Math.ceil(randNum) - randNum > randNum - Math.floor(randNum))
					iOrientation = 1;
				else iOrientation = -1;
				searchCase = 2;
				
				if ((iOrientation == 1 && y + word.length() - 1 >= BOARD_SIZE) || (iOrientation == -1 && x + word.length() - 1 >= BOARD_SIZE)) {
					positionCheck = false;
					x = r.nextInt(BOARD_SIZE);
					y = r.nextInt(BOARD_SIZE);
				}
			}
			
			if (positionCheck) {
				switch(searchCase){
				case 1:
					int index = word.indexOf(board[x][y]);
					if (iOrientation == 1) {
						for(int i = 0; i < word.length(); i++) {
							if (i == index) continue;
							board[x][y-index+i] = word.charAt(i);
							orientation[x][y-index+i] = iOrientation;
						}
					} else {
						for(int i = 0; i < word.length(); i++) {
							if (i == index) continue;
							board[x-index+i][y] = word.charAt(i);
							orientation[x-index+i][y] = iOrientation;
						}
					}
					break;
				case 2:
					if (iOrientation == 1) {
						for (int i = 0; i < word.length(); i++) {
							board[x][y + i] = word.charAt(i);
							orientation[x][y + i] = iOrientation;
						}
					} else {
						for(int i = 0; i < word.length(); i++) {
							board[x + i][y] = word.charAt(i);
							orientation[x + i][y] = iOrientation;
						}
					}
					break;
				default:
					System.out.println("Error: Word " + word + " cannot be added");
					break;
				}
				wordCount++;
			} 
			if (!positionCheck){
				x++;
				if (x % BOARD_SIZE == 0) {
					x = 0;
					y++;
				}
				if (y % BOARD_SIZE == 0)
					y = 0;
				if (x == oX && y == oY) {
					overlapCheck = true;
					searchCase = 2;
				}
			}
		}
	}
	
	public void fillRemainder() {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		for (int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == '0') {
					board[i][j] = letters.charAt(r.nextInt(letters.length()));
				}
			}
		}
	}
	
	public void generate(ArrayList<String> words) {
		for (String word : words) {
			addToBoard(word);
		}
		fillRemainder();
	}
	
	public String displayBoard() {
		String display = "";
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				display += board[i][j] + "\t";
			}
			display += "\n";
		}
		return display;
	}
	
	public String displayWords(ArrayList<String> words) {
		String wordList = "";
		int i = 0;
		for(String word: words) {
			wordList += word + "\t";
			i++;
			if (i % 4 == 0) 
				wordList += "\n";
		}
		return wordList;		
	}
}
