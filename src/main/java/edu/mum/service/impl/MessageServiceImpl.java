/**
 * 
 */
package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.MessageDao;
import edu.mum.domain.Messages;

/**
 * @author Diana Yamaletdinova
 * May 22, 2017
 */
@Service
@Transactional 
public class MessageServiceImpl implements edu.mum.service.MessageService{

	@Autowired 
	MessageDao messageDao;
	
	@Override
	public void save(Messages msg) {
		messageDao.save(msg);		
	}

	@Override
	public Messages findByUserId(String id) {
		return messageDao.findByUserId(id);
	}

	
	@Override
	public Messages update(Messages msgToBeAdded) {
		return messageDao.update(msgToBeAdded);		
	}

	@Override
	public List<Messages> findAll() {
		return (List<Messages>) messageDao.findAll();
	}

}
