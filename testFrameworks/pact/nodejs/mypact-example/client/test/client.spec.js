const chai = require('chai')
const path = require('path')
const chaiAsPromised = require('chai-as-promised')
const Pact = require('@pact-foundation/pact').Pact
const { somethingLike: like, term } = require('@pact-foundation/pact').Matchers
const expect = chai.expect

const client = require('../client')
chai.use(chaiAsPromised)

// Configure and import consumer API
// Note that we update the API endpoint to point at the Mock Service
const LOG_LEVEL = process.env.LOG_LEVEL || 'WARN'
const API_PORT = process.env.API_PORT || 3333

const provider = new Pact({
  consumer: 'Consumer',
  provider: 'Provider',
  port: API_PORT,
  log: path.resolve(process.cwd(), 'logs', 'pact.log'),
  dir: path.resolve(process.cwd(), 'pacts'),
  logLevel: LOG_LEVEL,
  spec: 2,
})

describe('Pact with Our Provider', () => {
  before(() => {
    return provider.setup()
  })

  describe('when a call to the Provider is made', () => {
    describe('and a valid url is provided', () => {
      before(() => {
        return provider.addInteraction({
          // state: 'date count > 0',
          uponReceiving: 'a request for JSON data',
          withRequest: {
            method: 'GET',
            path: '/name',
            // query: { validDate: submissionDate },
          },
          willRespondWith: {
            status: 200,
            // headers: {
              // 'Content-Type': 'application/json; charset=utf-8',
            // },
            body: {
              title: 'myTitle',
              count: 4
            },
          },
        })
      })

      it('can process the JSON payload from the provider', done => {
        const response = client.getName();
        // console.log(response);
        // expect(response).to.eventually.have.property('count', 4)
        expect(response).to.eventually.have.property('title', 'MyTitle').notify(done)
      })

      it('should validate the interactions and create a contract', () => {
        return provider.verify()
      })
    })
  })

  // Write pact files to file
  after(() => {
    return provider.finalize()
  })
})
