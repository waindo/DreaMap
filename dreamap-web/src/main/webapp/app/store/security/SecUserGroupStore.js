/**
 * Created by UwieSilent on 1/15/2015.
 */
Ext.define('app.store.security.SecUserGroupStore', {
    extend: 'Ext.data.Store',
    model: 'app.model.security.SecUserGroup',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '/usergroup.action',
        reader: {
            root: 'data',
            totalProperty: 'total',
            successProperty: 'success'
        }
    }
});