package saeut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saeut.dao.CheckListDao;
import saeut.dao.PostDao;
import saeut.domain.CheckList;
import saeut.domain.Comment;
import saeut.domain.Post;
import saeut.domain.Tag;
import saeut.dao.TagDao;
import saeut.dao.CommentDao;
import saeut.service.facade.PostFacade;

@Repository
@Service("postImpl")
@Transactional
public class PostImpl implements PostFacade {

	@Autowired
	private PostDao postDao;
	@Autowired
	private CheckListDao checkListDao;
	@Autowired
	private TagDao tagDao;
	@Autowired
	private CommentDao commentDao;
	
	public void setCheckListDao(CheckListDao checkListDao) {
		this.checkListDao = checkListDao;
	}

	/* Post  */
	@Override
	public List<Post> getAllPost() {
		return postDao.getAllPost();
	}

	@Override
	public List<Post> getPostByUserId(String userId) {
		return postDao.getPostByUserId(userId);
	}
	
	@Override
	public List<Post> getPostByType(int type) {
		// TODO Auto-generated method stub
		return postDao.getPostByType(type);
	}

	@Override
	public List<Post> getPostByTitle(String title) {
		// TODO Auto-generated method stub
		return postDao.getPostByTitle(title);
	}

	@Override
	@Transactional
	public void insertPost(Post Post) {
		postDao.insertPost(Post);
		int post_id = Post.getPost_id(); 
		System.out.println("PostImpl : " + post_id);
		
		List<String> tagList = Post.getTagList();
		for(String tagName:tagList) {
			Tag tag = new Tag(post_id, tagName);
			tagDao.insertTag(tag);
		}
	}

	@Override
	public void modPost(Post Post) {
		postDao.modPost(Post);
	}

	@Override
	public void removePost(int post_id) {
		postDao.removePost(post_id);
	}
	
	@Override
	public boolean isExistPostId(int post_id) {
		return postDao.isExistPostId(post_id);
	}
	
	
	/* CheckList  */
	@Override
	public List<CheckList> getAllCheckList() {
		return checkListDao.getAllCheckList();
	}

	@Override
	public List<CheckList> getTop6CheckList() {
		return checkListDao.getTop6CheckList();
	}

	@Override
	public List<Comment> getCommentByUserId(String id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByUserId(id);
	}

	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return commentDao.getAllComment();
	}

	@Override
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.insertComment(comment);
	}

	@Override
	public void modComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.modComment(comment);
	}

	@Override
	public void removeComment(int commet_id) {
		// TODO Auto-generated method stub
		commentDao.removeComment(commet_id);
	}

	@Override
	public List<Tag> getAllTag() {
		// TODO Auto-generated method stub
		return tagDao.getAllTag();
	}

	@Override
	public List<Tag> getTagByPostID(int post_id) {
		// TODO Auto-generated method stub
		return tagDao.getTagByPostID(post_id);
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.insertTag(tag);
	}

	@Override
	public void removeTag(int post_id) {
		// TODO Auto-generated method stub
		tagDao.removeTag(post_id);
	}

	
}


