
public class Rank {
	private int rank_1;
	private int rank_2;
	private int rank_3;
	private int lifePt;
	private int curRank;
	
	public Rank()
	{
		this (0, 0, 0, 0, 0);
	}

	public Rank(int rank1, int rank2, int rank3,int lifept,int userRank)
	{
		
		 rank_1 = rank1;
		 rank_2 = rank2;
		 rank_3 = rank3;
		 lifePt = lifept;
		 curRank = userRank;
		
	}
	public int getRank1() {
		return rank_1;
	}
	public int getRank2() {
		return rank_2;
	}
	public int getRank3() {
		return rank_3;
	}
	public int getlifept() {
		return lifePt;
	}
	public int getcurRank() {
		return curRank;
	}
	public void setRank1(int new_points) {
		rank_1 = new_points;
	}
	public void setRank2(int new_points) {
		rank_2 = new_points;
	}
	public void setRank3(int new_points) {
		rank_3 = new_points;
	}
	public void setlifept(int new_points) {
		lifePt = new_points;
	}
	public void setcurRank(int rank) {
		curRank = rank;
	}
}
