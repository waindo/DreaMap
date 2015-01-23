/**
 * Created by UwieSilent on 1/15/2015.
 */
Ext.define('app.view.security.usergroup.list' ,{
    extend: 'Ext.window.Window',
    alias: 'widget.userGroupList',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    loadMask: 'true',
    autoShow: true,
    title: 'User Group',
    constrain: true,
    dockedItems: [{
        tbar: [
            '->'
            , {
                text: 'Refresh',
                iconCls: 'reload',
                handler: function () {
                    grid.getStore().load();
                }
            }
        ]
    }],
    items: [{
        xtype: 'gridpanel',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        },
        store: 'app.store.security.SecUserGroupStore',
        columns: [{
            text: 'ID',
            width: 100,
            dataIndex: 'userGroupNo'
        }, {
            text: 'User Group',
            width: 300,
            dataIndex: 'userGroupName'
        }, {
            text: 'Description',
            width: 400,
            dataIndex: 'userGroupDesc'
        }, {
            text: 'Active',
            width: 50,
            dataIndex: 'active'
        }, {
            text: 'Last Updated',
            width: 150,
            dataIndex: 'lastUpdated'
        }, {
            text: 'Updater',
            width: 100,
            dataIndex: 'updater'
        }],
        bbar: Ext.create('Ext.PagingToolbar', {
            store: this.store,
            displayInfo: true,
            pageSize: 10,
            displayMsg: 'User Group List',
            emptyMsg: 'Tidak ada record!'
        })
    }]

});
