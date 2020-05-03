package extend;

import java.sql.*;
import java.util.*;

public class tag_DAO extends Book implements tag_DAO_interface {
	
	Connection con = null;
	PreparedStatement ps;
	
	// Update a tag w/ isbn
	@Override
	public boolean updatetag(String isbn13, String tag_name) {
		try {
			con = Kinect.getConnection();
			String query = "UPDATE book_tags SET tag_name = ? WHERE isbn_13 = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, tag_name);
			ps.setString(2, isbn13);
			if(ps.executeUpdate()!=0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	// Delete a tag w/ isbn
	@Override
	public boolean deletetag(String isbn13) {
		try {
			con = Kinect.getConnection();
			String query = "DELETE FROM book_tags WHERE isbn_13 = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, isbn13);
			if(ps.executeUpdate() != 0) 
				return true;
			else
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		} finally {
			closeResources();
		}
	}
	
	// Add a isbn and tag/add recor
	@Override
	public boolean addtag(String isbn_13,String tag_name) {
		try {
			con = Kinect.getConnection();
			String query = "INSERT INTO book_tags VALUES (?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, isbn_13);
			ps.setString(2, tag_name);
			if(ps.executeUpdate() != 0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	// Inner join tag and books
	@Override
	public List<tag_columns> getAlltags() {
		List<tag_columns> tag = new ArrayList<>();
		try {
			con = Kinect.getConnection();
			String query = "SELECT * FROM books INNER JOIN book_tags ON books.isbn_13 = book_tags.isbn_13 WHERE book_tags.isbn_13 IS NOT NULL";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tag_columns obj = new tag_columns();
				obj.setIsbn13(rs.getString("isbn_13"));
				obj.setTitle(rs.getString("title"));
				obj.setAuthor(rs.getString("author"));
				obj.setTagnames(rs.getString("tag_name"));
				obj.setPublishDate(rs.getDate("publish_date").toLocalDate());
				obj.setPrice(rs.getDouble("price"));
				obj.setContent(rs.getBytes("content"));
				tag.add(obj);
			} 
		
			for (int i =0; i<tag.size();i++) {
				System.out.println(tag.get(i).getIsbn13());
				System.out.println(tag.get(i).getTitle());
				System.out.println(tag.get(i).getAuthor());
				System.out.println(tag.get(i).getTag_names());
				System.out.println(tag.get(i).getPublishDate());
				System.out.println(tag.get(i).getPrice());
				System.out.println(tag.get(i).getContent());
		} rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
			return tag;
		
	}
	
	// Finding specific isbn/tag
	@Override
	public List<tag_columns> getAlltagsbyisbn(String isbn_13){
		List<tag_columns> tag = new ArrayList<>();
		try {
			con = Kinect.getConnection();
			String query = "SELECT isbn_13, tag_name FROM book_tags WHERE isbn_13 = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, isbn_13);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tag_columns obj = new tag_columns();
				obj.setIsbn13(rs.getString(1));
				obj.setTagnames(rs.getString(2));
				tag.add(obj);
			}
			for (int i =0;i<tag.size();i++) {
				System.out.println(tag.get(i).getIsbn13());
				System.out.println(tag.get(i).getTag_names());
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
			return tag;
	}
	
	
	// Checks if prepared statement and connection are closed
	private void closeResources() {
		try {
			if(ps != null) 
				ps.close();
			} catch (SQLException e) {
				System.out.println("Could not close statement");
				e.printStackTrace();
			}
			try {
				if(con != null) 
					con.close();
				} catch (SQLException e) {
					System.out.println("Could not close connection");
					e.printStackTrace();
				}
			}
	
	// test main
	public static void main (String[] args) {
		tag_DAO obj = new tag_DAO();
//		obj.getAlltagsbyisbn("1342346231456");
//		obj.addtag("1029364718273","Science Fiction");
//		obj.deletetag("1029364718273");
//		obj.updatetag();
		obj.getAlltags();
	}
}
	
	

