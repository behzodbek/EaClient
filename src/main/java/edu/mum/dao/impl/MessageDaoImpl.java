/**
 * 
 */
package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MessageDao;
import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.Messages;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;

/**
 * @author Diana Yamaletdinova May 21, 2017
 */
@SuppressWarnings("unchecked")
@Repository
public class MessageDaoImpl extends GenericDaoImpl<Messages> implements MessageDao {

	public MessageDaoImpl() {
		super.setDaoType(Messages.class);
	}
	@Override
	public Messages findByUserId(String id) {
		// TODO retreive all messages
		// we might need to change the db
		// Query query = entityManager.createQuery("select m from Messages m
		// where m.user_id =:userId");
		// return (Messages) query.setParameter("id", id).getSingleResult();
		return null;
	}

}
