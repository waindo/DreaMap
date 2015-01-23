/**
 * Created by UwieSilent on 1/15/2015.
 */
Ext.define('app.model.security.SecUserGroup', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'userGroupNo', type: 'string'},
        {name: 'userGroupName', type: 'string'},
        {name: 'userGroupDesc', type: 'string'},
        {name: 'active', type: 'boolean'},
        {name: 'lastUpdated', type: 'date', dateFormat: 'timestamp'},
        {name: 'updater', type: 'string'}
    ],
    idProperty: 'userGroupNo'
});