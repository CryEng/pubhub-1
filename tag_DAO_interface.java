package extend;

import java.util.*;
interface tag_DAO_interface {
	
	public List<tag_columns> getAlltagsbyisbn(String isbn_13);
	public List<tag_columns> getAlltags();
	public boolean addtag(String isbn_13,String tag_name);
	public boolean deletetag(String isbn13);
	public boolean updatetag(String isbn13, String tag_name);
}
