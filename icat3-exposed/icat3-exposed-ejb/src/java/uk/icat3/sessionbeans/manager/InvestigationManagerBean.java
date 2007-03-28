/*
 * InvestigationManagerBean.java
 *
 * Created on 26 March 2007, 15:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.icat3.sessionbeans.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.apache.log4j.Logger;
import uk.icat3.entity.Investigation;
import uk.icat3.entity.Investigator;
import uk.icat3.entity.Keyword;
import uk.icat3.exceptions.InsufficientPrivilegesException;
import uk.icat3.exceptions.NoSuchObjectFoundException;
import uk.icat3.exceptions.SessionException;
import uk.icat3.exceptions.ValidationException;
import uk.icat3.manager.InvestigationManager;
import uk.icat3.sessionbeans.ArgumentValidator;
import uk.icat3.sessionbeans.EJBObject;
import uk.icat3.sessionbeans.user.UserSessionLocal;
import uk.icat3.util.InvestigationInclude;

/**
 * This web service exposes the functions that are needed on investigation
 *
 * @author gjd37
 */
@Stateless()
@WebService()
//this interceptor check no nulls passed in and logs the method arguments
@Interceptors(ArgumentValidator.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class InvestigationManagerBean extends EJBObject implements InvestigationManagerLocal {
    
    static Logger log = Logger.getLogger(InvestigationManagerBean.class);
    
    @EJB
    UserSessionLocal user;
    
    /** Creates a new instance of InvestigationManagerBean */
    public InvestigationManagerBean() {}
    
    /**
     * 
     * @param sessionId 
     * @param investigationId 
     * @throws uk.icat3.exceptions.SessionException 
     * @throws uk.icat3.exceptions.InsufficientPrivilegesException 
     * @throws uk.icat3.exceptions.NoSuchObjectFoundException 
     * @return 
     */
    @WebMethod(operationName="getInvestigationDefault")
    @RequestWrapper(className="uk.icat3.sessionbeans.manager.getInvestigationDefault")
    @ResponseWrapper(className="uk.icat3.sessionbeans.manager.getInvestigationDefaultResponse")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Investigation getInvestigation(String sessionId, Long investigationId) throws SessionException, InsufficientPrivilegesException, NoSuchObjectFoundException {
        
        //for user bean get userId
        String userId = user.getUserIdFromSessionId(sessionId);
        
        return InvestigationManager.getInvestigation(userId, investigationId, manager);
    }
        
    /**
     * 
     * @param sessionId 
     * @param investigationId 
     * @param includes 
     * @throws uk.icat3.exceptions.SessionException 
     * @throws uk.icat3.exceptions.InsufficientPrivilegesException 
     * @throws uk.icat3.exceptions.NoSuchObjectFoundException 
     * @return 
     */
    @RequestWrapper(className="uk.icat3.sessionbeans.manager.getInvestigationIncludes")
    @ResponseWrapper(className="uk.icat3.sessionbeans.manager.getInvestigationIncludesResponse")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Investigation getInvestigation(String sessionId, Long investigationId, InvestigationInclude includes) throws SessionException, InsufficientPrivilegesException, NoSuchObjectFoundException {
        
        //for user bean get userId
        String userId = user.getUserIdFromSessionId(sessionId);
        
        Investigation investigation = InvestigationManager.getInvestigation(userId, investigationId, manager);
        
        //now set the investigation includes for JAXB web service
        investigation.setInvestigationInclude(includes);
        
        return investigation;
    }    
    
    /**
     * 
     * @param sessionId 
     * @param keyword 
     * @param investigationId 
     * @throws uk.icat3.exceptions.SessionException 
     * @throws uk.icat3.exceptions.ValidationException 
     * @throws uk.icat3.exceptions.InsufficientPrivilegesException 
     * @throws uk.icat3.exceptions.NoSuchObjectFoundException 
     */
    public void addKeyword(String sessionId, Keyword keyword, Long investigationId) throws SessionException, ValidationException, InsufficientPrivilegesException, NoSuchObjectFoundException{
        
        //for user bean get userId
        String userId = user.getUserIdFromSessionId(sessionId);
        
        InvestigationManager.addKeyword(userId, keyword, investigationId, manager);        
    }
    
    /**
     * 
     * @param sessionId 
     * @param investigator 
     * @param investigationId 
     * @throws uk.icat3.exceptions.SessionException 
     * @throws uk.icat3.exceptions.ValidationException 
     * @throws uk.icat3.exceptions.InsufficientPrivilegesException 
     * @throws uk.icat3.exceptions.NoSuchObjectFoundException 
     */
     public void addInvestigator(String sessionId, Investigator investigator, Long investigationId) throws SessionException, ValidationException, InsufficientPrivilegesException, NoSuchObjectFoundException{
        
        //for user bean get userId
        String userId = user.getUserIdFromSessionId(sessionId);
        
        InvestigationManager.addInvestigator(userId, investigator, investigationId, manager);        
    }         
}