package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Bank_account;


public class Bank_dao 
{

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public void save_Account(Bank_account bank_account) 
	{
		entityTransaction.begin();
		entityManager.persist(bank_account);
		entityTransaction.commit();		
	}
	public List<Bank_account> fetchAll() {
	List<Bank_account> list	=entityManager.createQuery("select x from Bank_account x").getResultList();
		return list;
	}
	public  Bank_account Bank_account_fetch_account_details(long acc_no)
	{
		Bank_account bank_account=entityManager.find(Bank_account.class,acc_no);
		return bank_account;
	}

		
	public void update_the_account_status(Bank_account bank_account) 
	{

		entityTransaction.begin();
		entityManager.merge(bank_account);
		entityTransaction.commit();
		
	}
	public Bank_account find(long ac_number ) 
	{
		Bank_account bank_account =entityManager.find(Bank_account.class,ac_number);
		return bank_account;
	}
}
