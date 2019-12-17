import axios from 'axios'

const SERVER_URL = 'http://localhost:9090'

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
})

export default {

    async execute (method, resource, data, config) {
        return instance({
            method: method,
            url: resource,
            data,
            ...config
        })
    },

    // (C)reate Event
    //createNewEvent: (Event) => instance.post('members', Event),

    // (R)ead
    getAllEvents () {
        return this.execute('GET', 'events', null, {
            transformResponse: [function (data) {
                return JSON.parse(data)
            }]
        })
    },
    // (U)pdate Event
    //updateForIdEvent: (id, name, firstName) => instance.put('members/' + id, {name: name, firstName: firstName}),

    // (D)elete Event
    //removeForIdEvent: (id) => instance.delete('members/' + id)
}
