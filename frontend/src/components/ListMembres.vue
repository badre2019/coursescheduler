<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="members"
                sort-by="name"
                class="elevation-1"
        >
            <template v-slot:top>
                <v-toolbar flat color="white">
                    <v-toolbar-title>List of members</v-toolbar-title>
                    <v-divider
                            class="mx-4"
                            inset
                            vertical
                    ></v-divider>
                    <div class="flex-grow-1"></div>
                    <v-dialog v-model="dialog" max-width="500px">
                        <template v-slot:activator="{ on }">
                            <v-btn color="primary" dark class="mb-2" v-on="on">Add Member</v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                <span class="headline">{{ formTitle }}</span>
                            </v-card-title>

                            <v-card-text>
                                <v-container>
                                    <v-row>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-text-field v-model="editedItem.name" label="name"></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-text-field v-model="editedItem.firstName" label="first name"></v-text-field>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </v-card-text>

                            <v-card-actions>
                                <div class="flex-grow-1"></div>
                                <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                                <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-toolbar>
            </template>
            <template v-slot:item.action="{ item }">
                <v-icon
                        small
                        class="mr-2"
                        @click="editItem(item)"
                >
                    mdi-pencil
                </v-icon>
                <v-icon
                        small
                        @click="deleteItem(item)"
                >
                    mdi-delete
                </v-icon>
            </template>
        </v-data-table>
    </div>
</template>

<script>
    import apimember from "../apiMember";

    export default {
        name: "ListMembres",
        data: () => ({
            dialog: false,
            headers: [
                {
                    text: 'Name',
                    align: 'left',
                    sortable: false,
                    value: 'name',
                },
                {
                    text: 'First Name',
                    value: 'firstName'
                },
                {
                    text: 'Actions',
                    value: 'action',
                    sortable: false
                },
            ],
            members: [],
            editedIndex: -1,
            editedItem: {
                id: null,
                name: '',
                firstName: ''
            },
            defaultItem: {
                id: null,
                name: '',
                firstName: ''
            },
        }),
        computed: {
            formTitle () {
                return this.editedIndex === -1 ? 'Add Member' : 'Edit Member'
            },
        },

        watch: {
            dialog (val) {
                val || this.close()
            },
        },

        created () {
            this.initialize()
        },

        methods: {

            initialize () {
                apimember.getAll()
                .then(response => {
                    this.members = response.data
                })
            },

            editItem (item) {
                this.editedIndex = this.members.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },

            deleteItem (item) {
                const index = this.members.indexOf(item)
                confirm('Are you sure you want to delete this member?') && this.members.splice(index, 1)
                apimember.removeForId(item.id)
            },

            close () {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },

            save () {
                if (this.editedIndex > -1) {
                    Object.assign(this.members[this.editedIndex], this.editedItem)
                } else {
                    this.members.push(this.editedItem)
                }
                this.close()
                if(this.editedIndex === -1){
                    apimember.createNewMember(this.editedItem)
                }else{
                    apimember.updateForIdMember(this.editedItem.id, this.editedItem)
                }
            },
        },
    }
</script>

<style scoped>

</style>
