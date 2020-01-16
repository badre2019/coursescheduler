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

    // (C)reate Participant
    createNewParticipant: (participant) => instance.post('participants', participant),

    // (R)ead
    getAllEvents () {
        return this.execute('GET', 'participants/', null, {
            transformResponse: [function (data) {
                return JSON.parse(data)
            }]
        })
    },
    // (U)pdate Participant
    //updateForIdEvent: (id, name, firstName) => instance.put('participants/' + id, {name: name, firstName: firstName}),

    // (D)elete Participant
    //removeForIdEvent: (id) => instance.delete('members/' + id)
}
