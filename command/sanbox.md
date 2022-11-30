# 异常制造
```shell
cd /opt/sandbox/bin
./sandbox.sh -p 66 -d 'repeater/delay?class=com.xsyx.trade.stock.query.service.api.facade.ProductLimitFacade&method=queryLimit&delay=800'
./sandbox.sh -p 77 -d 'repeater/wreck?class=com.frxs.trade.user.core.service.engine.chain.node.create.CreateCoreProcessorNode&method=process&type=RuntimeException'
```