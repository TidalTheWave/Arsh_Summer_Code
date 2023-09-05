package test;

public class ConwayCell {

	private boolean alive;
	private int x;
	private int y;

	public ConwayCell(int x, int y) {
		alive = false;
		this.x = x;
		this.y = y;
	}

	public void act() {
		if (alive && (getNeighbors() > 3 || getNeighbors() < 2)) {
			ConwayGame.queueKill(x, y);
		} 
		else if (!alive && getNeighbors() == 3) {
			ConwayGame.queueRevive(x, y);
		}
	}

	public void kill() {
		alive = false;
	}

	public void revive() {
		alive = true;
	}

	public int getNeighbors() {
		int neighbors = 0;
		int x = this.x;
		int y = this.y;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (x + i >= 0 && x + i < ConwayGame.height() && y + j >= 0 && y + j < ConwayGame.length())
					if (ConwayGame.isCellAlive(x + i, y + j) && !(i == 0 && j == 0)) {
						neighbors++;
					}
			}
		}
		return neighbors;
	}

	public boolean isAlive() {
		return alive;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
