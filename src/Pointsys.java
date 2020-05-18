
public class Pointsys {
	


	public void correct(int quest_rank, Rank data)
	{
		int x = 0;
		int y = 0;
		
		x = data.getlifept() + 15;
		data.setlifept(x);
		if (quest_rank  == 1 && data.getRank1() != 300)
			{
			y = data.getRank1() + 15;
			data.setRank1(y);
			}
		if (quest_rank  == 2 && data.getRank2() != 300)
			{
			y = data.getRank2() + 15;
			data.setRank2(y);
			}
		if (quest_rank  == 3 && data.getRank3() != 300)
			{
			y = data.getRank3() + 15;
			data.setRank3(y);
			}			
	}
	
	public void wrong(int quest_rank, Rank data)
	{
		
		int temp = 0;
		
		if (data.getRank3() > 0){
			temp = data.getRank3() - 10;
			data.setRank3(temp);
		}
		else if(data.getRank2() > 0) {
			temp = data.getRank2() - 10;
			data.setRank2(temp);
		}
		else {
			temp = data.getRank1() - 10;
			data.setRank1(temp);
		}
	}
	
	public int evaluate(Rank data)
	{
		int x = data.getRank1();
		int y = data.getRank2();
		int z = data.getRank3();
		int a = data.getlifept();
		int totalpt = x + y + z;
		
		if (totalpt > 0) {
			if (z >= totalpt / 3 && a > 300 )
			{
				data.setcurRank(3);
			}
			else if (y >= totalpt / 3 && a > 150 )
			{
				data.setcurRank(2);
			}
			else
			{
				data.setcurRank(1);
			}
		}
		else
		{
			data.setcurRank(1);
		}
		return data.getcurRank();
	}
				
	
}
