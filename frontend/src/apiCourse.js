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

    // (C)reate Course
    createNewCourse: (name) => instance.post('courses', {name: name}),

    // (R)ead
    getAllCourses () {
        return this.execute('GET', 'courses', null, {
            transformResponse: [function (data) {
                return JSON.parse(data)
            }]
        })
    },
    // (U)pdate Course
    updateForIdCourse: (id, name) => instance.put('courses/' + id, {name: name}),

    // (D)elete Course
    removeForIdCourses: (id) => instance.delete('courses/' + id)
}
