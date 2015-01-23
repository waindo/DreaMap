package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecAuditLog;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecAuditLogDao {

    public SecAuditLog findById(Long auditLogId);

}
