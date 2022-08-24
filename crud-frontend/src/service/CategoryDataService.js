import axios from 'axios'

const CATEGORY_API_URL = '/api/v1/category'

class CategoryDataService {

    retrieveAllCategories() {

        return axios.get(`${CATEGORY_API_URL}`);
    }

    retrieveCategory(id) {

        return axios.get(`${CATEGORY_API_URL}/${id}`);
    }

    deleteCategory(id) {

        return axios.delete(`${CATEGORY_API_URL}/${id}`);
    }

    updateCategory(id, ctg) {

        return axios.put(`${CATEGORY_API_URL}/${id}`, ctg);
    }

    createCategory(ctg) {
        console.log(ctg)
        return axios.post(`${CATEGORY_API_URL}`, ctg);
    }   
}

export default new CategoryDataService()