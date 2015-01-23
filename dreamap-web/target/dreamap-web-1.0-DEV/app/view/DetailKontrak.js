var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
Ext.define('app.view.DetailKontrak', {
    extend: 'Ext.window.Window',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    autoShow: true,
    title: 'Detail Kontrak',
    bodyStyle:"background:#ffffff;",
    closeAction: 'hide',
    layout: {
        type: 'hbox',
    },
    items:[{
            xtype: 'form',
            bodyPadding: 10,
            closeAction: 'hide',
            layout: 'form',
            border:false,
            fieldDefaults: {
                msgTarget: 'side',
                labelWidth: 125
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Kode WO',
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
                fieldLabel: 'Status',
                afterLabelTextTpl: required,
                name: 'status',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name'
            }, {
                fieldLabel: 'Tgl Permohonan',
                name: 'tglpermohonan',
                xtype: 'datefield',
                afterLabelTextTpl: required,
                allowBlank: false,
                //readOnly:true,
                //tooltip: 'Enter your date of birth'
            }, {
                fieldLabel: 'Koordinat Lat',
                afterLabelTextTpl: required,
                name: 'status',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name'
            }, {
                fieldLabel: 'Koordinat Lng',
                afterLabelTextTpl: required,
                name: 'status',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name'
            }, {
                xtype: 'textarea',
                fieldLabel: 'Keterangan',
                afterLabelTextTpl: required,
                name: 'Keterangan',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name']
            },{
                xtype: 'filefield',
                emptyText: 'Masukan Sketsa',
                fieldLabel: 'Photo',
                name: 'photo-path',
                buttonText: '',
                buttonConfig: {
                    iconCls: 'upload-icon'
                }
            }],
                    flex:2
        },{
            xtype: 'grid',
            flex:1,
            id: 'namaaset',
            viewConfig: {
                stripeRows: true
            },
            height: 115,
            margin:'10 10 10 10',
            style: 'border: solid #99bce8 1px',
            columns: [{
                text: 'Nama Aset',
                flex:1
            }]
        }],
    buttons: [{
        text: 'Save',
        handler: function() {
            this.up('window').down('form').getForm().isValid();
        }
    }, {
        text: 'Cancel',
        handler: function() {
          this.up('window').down('form').getForm().reset();
            this.up('window').hide();
        }
    }]



});