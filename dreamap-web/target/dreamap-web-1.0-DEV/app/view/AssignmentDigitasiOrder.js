var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
Ext.define('app.view.AssignmentDigitasiOrder', {
    extend: 'Ext.window.Window',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    autoShow: true,
    title: 'Assignment Digitasi Order',
    items: {
        xtype: 'form',
        bodyPadding: 10,
        layout: 'form',
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 125
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Kode DO',
            afterLabelTextTpl: required,
            name: 'kodewo',
            allowBlank: false,
            readOnly: true,
            // tooltip: 'Enter your first name'
        }, {
            fieldLabel: 'Jenis Aset',
            afterLabelTextTpl: required,
            name: 'jenisaset',
            allowBlank: false,
            readOnly: true,
            // tooltip: 'Enter your last name'
        }, {
            xtype: 'combobox',
            fieldLabel: 'Assign',
            afterLabelTextTpl: required,
            name: 'status',
            allowBlank: false,
            //readOnly: true,
            typeAhead: true,
            emptyText: 'Pilih assign...'
                // tooltip: 'Enter your last name'
        }, {
            xtype: 'filefield',
            emptyText: 'Masukan MXD file',
            fieldLabel: 'MXD Attachment',
            name: 'photo-path',
            buttonText: '',
            buttonConfig: {
                iconCls: 'upload-file'
            }
        }]
    },
    buttons: [{
        text: 'Save',
        handler: function() {
            Ext.getCmp('formassigmentdigitasiorder').getForm().isValid();
        }
    }, {
        text: 'Cancel',
        handler: function() {
            Ext.getCmp('formassigmentdigitasiorder').getForm().reset();
            this.up('window').hide();
        }
    }]



});