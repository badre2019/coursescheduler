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

    // (C)reate Member
    createNewMember: (member) => instance.post('members', member),

    // (R)ead
    getAll () {
        return this.execute('GET', 'members', null, {
            transformResponse: [function (data) {
                return JSON.parse(data)
            }]
        })
    },
    // (U)pdate Member
    updateForIdMember: (id, member) => instance.put('members/' + member.id, member),

    // (D)elete Member
    removeForId: (id) => instance.delete('members/' + id)
}
