/**
 * Created by UwieSilent on 1/15/2015.
 */
Ext.define('app.controller.SecurityController', {
    extend: 'Ext.app.Controller',
    views: ['app.view.security.usergroup.list'],
    models: ['app.model.security.SecUserGroup'],
    stores: ['app.store.security.SecUserGroupStore']
    //refs: [
    //    {
    //        ref: 'ugroupList',
    //        selector: 'list'
    //    },
    //    //{
    //    //    ref: 'ugroupGrid',
    //    //    selector: 'list grid'
    //    //}
    //    {
    //        ref: 'ugroupGrid',
    //        selector: 'grid'
    //    }
    //],
    //init: function() {
    //    this.control({
    //        'ugroupGrid': {
    //            afterrender: this.ugroupAfterRender
    //        }
    //    })
    //},
    ////ugroupAfterRender: function(comp) {
    ////    comp.down('grid').getStore('SecUserGroupStore').load();
    ////}
    //ugroupAfterRender: function() {
    //    this.getSecUserGroupStoreStore().loadData();
    //}

});