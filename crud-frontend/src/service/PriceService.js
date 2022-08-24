import axios from 'axios'

const PRICE_API_URL='/api/v1/price'

class PriceService{
    retrieveAllPrices() {

        return axios.get(`${PRICE_API_URL}`);
    }

    retrievePriceByCompNameAndItemName(compName, itemName) {

        return axios.get(`${PRICE_API_URL}?source=${compName}&item=${itemName}`);
    }
}

export default new PriceService();