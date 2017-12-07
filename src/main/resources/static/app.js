$(function () {
    var app = new Vue({
        el: '#mainComponent',
        data: {
            customers: [
                { id: "customer1", title: "Customer #1" },
                { id: "customer2", title: "Customer #2" }
            ],
            isEditMode: false,
            isAddMode: false,
            isSelectMode: true,
            edit: null,
            statuses: [
                { id: "1", title: "New" },
                { id: "2", title: "Approved" }
            ],
            selectByCustomerId: null,
            requests: []
        },
        methods: {
            findRequests: function () {
                if (!this.selectByCustomerId) {
                    return;
                }

                this.currentCustomerId = this.selectByCustomerId;
                var vue = this;
                window.console.log("Select by customer: " + this.selectByCustomerId);
                $.ajax("/api/requests/" + this.selectByCustomerId, {
                    method: "GET",
                }).done(function (json) {
                    vue.requests = json;
                })
            },
            addOrEdit: function () {
                this.isAddMode = false;
                this.isEditMode = false;
                var vue = this;
                if (this.edit.id > 0) {
                    $.ajax("/api/update", {
                        method: "PUT",
                        contentType: "application/json",
                        data: JSON.stringify({
                            id: vue.edit.id,
                            customer: vue.edit.customerId,
                            startDate: vue.edit.startDate,
                            endDate: vue.edit.endDate,
                            status: vue.edit.status
                        })
                    }).done(function (json) {
                        vue.isSelectMode = true;
                        vue.findRequests();
                    })
                } else {
                    vue.edit.id = new Date().getTime();
                    $.ajax("/api/create", {
                        method: "POST",
                        contentType: "application/json",
                        data: JSON.stringify({
                            id: vue.edit.id,
                            customer: vue.edit.customerId,
                            startDate: vue.edit.startDate,
                            endDate: vue.edit.endDate,
                            status: vue.edit.status
                        })
                    }).done(function (json) {
                        vue.edit = {}
                        vue.isSelectMode = true;
                        vue.findRequests();
                    })
                }
            },
            editRequest: function (r) {
                this.edit = r;
                this.isAddMode = false;
                this.isSelectMode = false;
                this.isEditMode = true;
            },
            deleteRequest: function (r) {
                if (confirm("Delete " + r.id + "?")) {
                    alert("Not implemented!");
                }
            },
            deleteAllByCustomer: function () {
                var vue = this;
                $.ajax("/api/delete/" + this.selectByCustomerId, {
                    method: "DELETE"
                }).done(function (json) {
                    vue.requests = [];
                })
            },
            addForm: function () {
                this.edit = {
                    id: 0,
                    customerId: "customer1",
                    startDate: "2017-12-09",
                    endDate: "2018-01-20",
                    status: "1"
                };
                this.isAddMode = true;
                this.isEditMode = false;
                this.isSelectMode = false;
            }
        }
    });
});