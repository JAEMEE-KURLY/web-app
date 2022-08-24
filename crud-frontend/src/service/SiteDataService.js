import axios from 'axios'

const SITE_API_URL = '/api/v1/site'

class SiteDataService {

    retrieveAllSites() {

        return axios.get(`${SITE_API_URL}`);
    }

    retrieveSite(id) {

        return axios.get(`${SITE_API_URL}/${id}`);
    }

    deleteSite(id) {

        return axios.delete(`${SITE_API_URL}/${id}`);
    }

    updateSite(id, site) {

        return axios.put(`${SITE_API_URL}/${id}`, site);
    }

    createSite(site) {
        return axios.post(`${SITE_API_URL}`, site);
    }   
}

export default new SiteDataService()