package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecProgram;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public interface ISecProgramDao {

    public List<SecProgram> getExcludeProgramsByUserGroupNo(String userGroupNo);

    public List<SecProgram> getProgramsByUserId(Long userId);

    public List<SecProgram> getPrograms();

    public List<SecProgram> getPrograms(int firstRecord, int lastRecord);

    public List<SecProgram> getProgramsByFilter(int firstRecord, int lastRecord, String filter);

    public SecProgram getProgramByUrl(String urlAddress);

    public SecProgram getProgramByNo(String programNo);

    public int countProgram();

    public int countProgramByFilter(String filter);

    public int saveProgram(SecProgram program);

    public int deleteProgram(String programNo);

    public SecProgram findByFirstRecord(String keyName);

    public SecProgram findByPrevRecord(String keyName, String keyValue);

    public SecProgram findByNextRecord(String keyName, String keyValue);

    public SecProgram findByLastRecord(String keyName);

}
