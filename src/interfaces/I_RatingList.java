package interfaces;
import Classes.*;

public interface I_RatingList {
	public void addRating(Rating r);
	public Rating pullRating();
	public void removeRating(Rating r);
}
