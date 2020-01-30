module.exports = async function (context, req) {
    context.log('JavaScript HTTP trigger function processed a request.');

    context.log('Input blob length: ' + context.bindings.inputDoc.length)

    context.res = {
        status: 200,
        body: context.bindings.inputDoc
    }
};